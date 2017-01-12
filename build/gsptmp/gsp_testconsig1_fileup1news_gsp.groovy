import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_testconsig1_fileup1news_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/fileup1/news.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'fileup1.label', default: 'Fileup1'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',6,['code':("default.create.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(2)
invokeTag('external','g',7,['dir':("css"),'file':("style1.css")],-1)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',137,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
expressionOut.print(createLink(uri:'/fileup1/consigMain'))
printHtmlPart(6)
expressionOut.print(createLink(uri:'/fileup1/tutorial'))
printHtmlPart(7)
expressionOut.print(createLink(uri:'/fileup1/citations'))
printHtmlPart(8)
expressionOut.print(createLink(uri:'/fileup1/overview'))
printHtmlPart(9)
expressionOut.print(createLink(uri:'/fileup1/faq'))
printHtmlPart(10)
expressionOut.print(createLink(uri:'/fileup1/news'))
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
invokeTag('submitButton','g',233,['name':("submit"),'" value':("submit"),'style':("color: #0F226E;padding: 10px 32px; font-family: Georgia, ..., serif;border-radius: 8px;box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19); font-size: 15px;;font-style:bold;")],-1)
printHtmlPart(13)
})
invokeTag('uploadForm','g',242,['controller':("fileup1"),'action':("inpPara"),'name':("myUpload")],2)
printHtmlPart(14)
})
invokeTag('captureBody','sitemesh',247,[:],1)
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1473885574000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
