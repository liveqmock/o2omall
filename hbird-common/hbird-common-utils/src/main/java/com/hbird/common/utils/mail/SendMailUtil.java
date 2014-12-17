package com.hbird.common.utils.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.hbird.common.utils.DateHelper;

/**
 * @author zhaohengchong
 * @email zhaohengchong@hbird.com
 * @version 2014年5月7日 下午3:00:43
 */
public class SendMailUtil {

    private static final Logger log = Logger.getLogger(SendMailUtil.class);

    private static final String MAIL_SMTP_AUTH = Boolean.TRUE.toString();
    private static final String MAIL_TRANSPORT_PROTOCOL = "smtp";
    private static final String MAIL_HOST = "mail.hbird.com";

    private static final String USERNAME = "lszxit";
    private static final String PASSWORD = "1qaz@WSX";

    private static final String FROM_MAIL_DOMAIN = "@hbird.com";
    private static final String CONTEXT_TYPE = "text/html;charset=gbk";

    public static void main(String[] args) {
        String orderId = "1234567890";
        String context = "【订单下传失败报警】订单号:【" + orderId + "】。报警级别:【ERROR】,报警时间:【" + DateHelper.getCurrentDateStr(null)
                + "】,报警内容:【订单库房ID为0或为空】。【乐视】";
        try {
            sendMail("【报警】订单下传邮件报警", context, "zhaohengchong@hbird.com,zhaohengchong@hbird.com");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * 使用 致新IT邮箱账号 发送邮件
     * 
     * @param title
     *            邮件主题，必须
     * @param context
     *            邮件内容，必须
     * @param sendMailAddress
     *            接受邮件地址，支持多个，使用","分割，无默认，必须
     * @throws Exception
     */
    public static void sendMail(String title, String context, String sendMailAddress) throws Exception {
        sendMail(null, null, null, null, null, title, context, null, null, sendMailAddress);
    }

    /**
     * 使用SMTP发送邮件通用方法
     * 
     * @param mailSmtpAuth
     *            使用 smtp 认证： "true" or "false"，默认 "true"
     * @param protocol
     *            协议，默认 "smtp"
     * @param mailHost
     *            发送邮件服务器， 默认 mail.hbird.com
     * @param username
     *            发送方用户名， 默认 致新信息IT邮箱
     * @param password
     *            发送方密码， 默认 致新信息IT邮箱
     * @param title
     *            发送标题，无默认，必须
     * @param context
     *            发送内容，无默认，必须
     * @param contextType
     *            发送内容类型，默认GBK
     * @param formMailAddress
     *            发送邮件地址，默认 username + "@hbird.com"
     * @param sendMailAddress
     *            接受邮件地址，支持多个，使用","分割，无默认，必须
     * @throws Exception
     */
    public static void sendMail(String mailSmtpAuth, String protocol, String mailHost, String username,
            String password, String title, String context, String contextType, String formMailAddress,
            String sendMailAddress) throws Exception {
        log.debug("发送邮件开始");
        
        try {
            if (StringUtils.isBlank(title) || StringUtils.isBlank(context) || StringUtils.isBlank(sendMailAddress)) {
                log.error("发送邮件必要参数为空，不发送");
                return;
            }
            
            Properties props = setProps(mailSmtpAuth, protocol, mailHost);
            if (StringUtils.isBlank(username)) {
                username = USERNAME;
            }
            if (StringUtils.isBlank(password)) {
                password = PASSWORD;
            }
            if (StringUtils.isBlank(formMailAddress)) {
                formMailAddress = username + FROM_MAIL_DOMAIN;
            }
            if (StringUtils.isBlank(contextType)) {
                contextType = CONTEXT_TYPE;
            }
            
            Session session = Session.getInstance(props, new MyAuthenticator(username, password));
            if (log.isDebugEnabled()) {
                session.setDebug(Boolean.TRUE);
            }
            
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(formMailAddress));
            msg.setSubject(title);
            msg.setRecipients(RecipientType.TO, InternetAddress.parse(sendMailAddress));
            msg.setContent(context, contextType);
            Transport.send(msg);
        } catch (Exception e) {
            log.error("使用SMTP发送邮件异常：", e);
            throw e;
        }
    }

    private static Properties setProps(String mailSmtpAuth, String protocol, String mailHost) {
        if (StringUtils.isBlank(mailSmtpAuth)) {
            mailSmtpAuth = MAIL_SMTP_AUTH;
        }
        if (StringUtils.isBlank(protocol)) {
            protocol = MAIL_TRANSPORT_PROTOCOL;
        }
        if (StringUtils.isBlank(mailHost)) {
            mailHost = MAIL_HOST;
        }
        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", mailSmtpAuth);
        props.setProperty("mail.transport.protocol", protocol);
        props.setProperty("mail.host", mailHost);
        return props;
    }
}

class MyAuthenticator extends Authenticator {
    String userName = null;
    String password = null;

    public MyAuthenticator() {
    }

    public MyAuthenticator(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(userName, password);
    }
}
