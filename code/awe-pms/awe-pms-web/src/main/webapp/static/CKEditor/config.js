/*
Copyright (c) 2003-2010, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

CKEDITOR.editorConfig = function( config )
{
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
    // config.uiColor = '#AADC6E';
    config.uiColor = '#F7F8F9'
    config.scayt_autoStartup = false
    config.language = 'zh-cn'; //中文
    config.filebrowserBrowseUrl = 'ckfinder/ckfinder.html';
    config.filebrowserImageBrowseUrl = 'ckfinder/ckfinder.html?Type=Images';
    config.filebrowserFlashBrowseUrl = 'ckfinder/ckfinder.html?Type=Flash';
    config.filebrowserUploadUrl = 'ckfinder/core/connector/aspx/connector.aspx?command=QuickUpload&type=Files';
    config.filebrowserImageUploadUrl = 'ckfinder/core/connector/aspx/connector.aspx?command=QuickUpload&type=Images';
    config.filebrowserFlashUploadUrl = 'ckfinder/core/connector/aspx/connector.aspx?command=QuickUpload&type=Flash';
};
