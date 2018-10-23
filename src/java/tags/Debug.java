/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author 759388
 */
public class Debug extends TagSupport
{
    @Override
    public int doStartTag() throws JspException 
    {
        String remoteHost = pageContext.getRequest().getRemoteHost();
        String debugParam = pageContext.getRequest().getParameter("debug");
        
        if ((!pageContext.getRequest().getServerName().equals("localhost") && !pageContext.getRequest().getServerName().equals("test.cprg352.com")) || pageContext.getRequest().getParameter("debug") == null)
            return SKIP_BODY;
        
        return EVAL_BODY_INCLUDE;
    }
}
