import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_testconsig1_fileup1result_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/fileup1/result.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)

StringBuffer html = new StringBuffer();
int setsize = d.size
System.out.println("inside count loop $setsize");
for(int i = 1; i<setsize;i++)
			{ 
				html.append("<tr>"
				+"<td bgcolor=\"#eeeeee\">"+(i+1)+"</td>"
				+"<td>"+d.get(i).getGenelist()+ "</td>"
			   +"<td>"+d.get(i).getGenesize()+ "</td>"
			   +"<td>"+d.get(i).getGenesym()+"</td>"
			  +"<td>"+d.get(i).getEntrid()+ "</td>"
			   +"<td>"+d.get(i).getIngenelist()+"</td>"
			   +"<td>"+d.get(i).getRawscore()+"</td>"
				+"<td>"+d.get(i).getPenalscore()+ "</td>"
			   +"<td>"+d.get(i).getScore()+"</td>"
			   
			   +"</tr>");
			   
			}

printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',32,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('require','r',33,['module':("export")],-1)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',35,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('formats','export',39,['formats':(['csv', 'excel']),'action':("result"),'params':([uuid:"${params.uuid}"])],-1)
printHtmlPart(6)
out.print(html.toString())
printHtmlPart(7)
})
invokeTag('captureBody','sitemesh',88,[:],1)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1469038272000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
