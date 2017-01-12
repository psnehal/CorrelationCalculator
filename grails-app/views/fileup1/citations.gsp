<!DOCTYPE html>
<html>
    <head>
     	<meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'fileup1.label', default: 'Fileup1')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>     
        <g:external dir="css" file="style1.css" />
    </head>
    <body>
    	
		
		<div id="textPanel">
		 
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
			
			<center>
			<div id="formPanel">	
			
	            Title: UniConSig: A new algorithm for genome-wide quantification of gene functions and disease associations 
	          
	        </div>
	        </div>
    
        
    </body>
</html>

