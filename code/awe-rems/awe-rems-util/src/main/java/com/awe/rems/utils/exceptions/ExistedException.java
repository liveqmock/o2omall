package com.awe.rems.utils.exceptions;

/**
 * 记录已存在异常 ：多用于添加数据时验证唯一
 * 
 * @author ljz
 * @version 2014-12-25 9:16:21
 * 
 */
public class ExistedException extends RuntimeException {

    /**
	 * 
	 */
    private static final long serialVersionUID = -8244308607506869202L;

    public ExistedException() {
        super();
    }

    public ExistedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExistedException(String message) {
        super(message);
    }

    public ExistedException(Throwable cause) {
        super(cause);
    }

}
