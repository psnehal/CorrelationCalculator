import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_testconsig1_fileup1genelist_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/fileup1/genelist.gsp" }
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
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
invokeTag('external','g',7,['dir':("css"),'file':("style1.css")],-1)
printHtmlPart(3)
invokeTag('javascript','asset',8,['src':("jquery-latest.js")],-1)
printHtmlPart(4)
invokeTag('javascript','asset',9,['src':("jquery.tablesorter.js")],-1)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
invokeTag('message','g',12,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(7)
loop:{
int i = 0
for( item in (listOfFiles.sort()) ) {
printHtmlPart(8)
expressionOut.print(i+1)
printHtmlPart(9)
expressionOut.print(item.getName())
printHtmlPart(10)
createClosureForHtmlPart(11, 3)
invokeTag('link','g',26,['controller':("fileup1"),'action':("downloadFile"),'params':([item:item])],3)
printHtmlPart(12)
i++
}
}
printHtmlPart(13)
})
invokeTag('captureBody','sitemesh',31,[:],1)
printHtmlPart(14)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1482269475000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
