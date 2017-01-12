

<% 
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
	
	
	

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta name="layout" content="main" />
        <r:require module="export"/>
       
    </head>
    <body>  
    
    <br/> 
    Download results:<export:formats formats="['csv', 'excel']" action="result" params="[uuid:"${params.uuid}"]" />
    <br/> 
		
    
    
   
    <div id="contentPanel">
			<table>
				<thead>
				<tr class="tableHeader">
				<td bgcolor="#eeeeee">
				     Index
			    </td>
			    <td>
				    <span class="text"><b>Genelist Size</b></span>
			    </td>
			   
			    <td>
			    	<span class="text"><b>Gene Symbol</b></span>
			    </td>
			    <td>
				    <span class="text"><b>Entrez ID</b></span>
			    </td>
			    <td>
			    	<span class="text"><b>In Genelist</b></span>
			    </td>
			    <td>
			    	<span class="text"><b>Raw Score</b></span>
			    </td>
			    <td>
			    	<span class="text"><b>Penal Score</b></span>
			    </td>
			    <td>
			    	<span class="text"><b>Score</b></span>
			    </td>
			    <td>
			    	<span class="text"><b>ConCepts</b></span>
			    </td>
			    
			  
			    
			   
		
		 </tr>
		 </thead>
		 <%= html.toString() %>
		</table>
	</div>
        
    </body>
</html>

