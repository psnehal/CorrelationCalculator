<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'fileup1.label', default: 'Fileup1')}" />
        <title> Gene List </title>
         <g:external dir="css" file="style1.css" />
         <asset:javascript src="jquery-latest.js" /> 
 		<asset:javascript src="jquery.tablesorter.js" />
    </head>
    <body>
    	 <div class="nav" role="navigation">
			<ul>
			 <li><a class="intro"  href="${createLink(uri:'/fileup1/consigMain')}">Web Service</a></li>
			 <li><a class="intro"  href="${createLink(uri:'/fileup1/tutorial')}">How It works!!!</a></li>			 
			 <li><a class="intro"  href="${createLink(uri:'/fileup1/citations')}">Citations</a></li>			
			<!--  <li><a class="intro"  href="${createLink(uri:'/fileup1/faq')}" download>FAQ</a></li>-->
			<!--  <li><a class="intro"  href="${createLink(uri:'/fileup1/news')}">News</a></li> -->
			   <li><a class="intro"  href="${createLink(uri:'/fileup1/genelist')}">Gene List Collection </a></li>
			 <li><a class="intro"  href="mailto: conceptmetab-help@umich.edu">Contacts</a></li>
			 
			 	
			</ul>
		</div> 
        <a href="#list-fileup1" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>        
	    <table>
		    <thead>
		         <tr>
		                 <th>index</a></th> 
		                <th> Gene List Name</a></th>                
		                <th> Download</a></th>
		        </tr>
		    </thead>
		    <tbody  id="myTable" class="tablesorter">
		             <g:each in="${listOfFiles.sort()}" var="item" status="i">
		              <tr class="even">
		              <td>${i+1}</td>    
					   <td> ${item.getName()}</td>
					   <td><g:link controller="fileup1" action="downloadFile" params="${[item:item]}">Download</g:link><br> </td>
					     </tr>
					  </g:each>
			 </tbody>
		 </table>      
     </body>
</html>
