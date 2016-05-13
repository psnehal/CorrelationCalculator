package testconsig1

import grails.transaction.Transactional
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.RList
import org.rosuda.REngine.Rserve.*;
import org.rosuda.Rserve.*;

@Transactional
class RetrieveSubmittedJobsService {
	
	RConnection c = new RConnection();
	def serviceMethod() {

    }
    
    def listalljobs() {
        println("in service")
        def qjobs = Consigparameters.createCriteria()
        def result= qjobs.list {
			eq("status","queued")
		}
        result.each { person ->
					    println "filepath = ${person.filepath}"
					    println "jiindex = ${person.jindex}"
					    println "uuid = ${person.uuid}"					   
					    println "min_con = ${person.minCon}"
					}
        
        def rjobs= Consigparameters.executeQuery("select uuid from Consigparameters where status ='running'")        
        println("below query with queued jobs $result.size() running jobs $rjobs.size")
        def rjobCount = rjobs.size()
        println("1")
        if (rjobCount<2)
        {
          def firstSubJob = result[0]
          println("1")
          println ("firstSubJob  $firstSubJob.uuid")
          def uuid= firstSubJob.uuid
          println("2")
          RConnection connection;
		  connection = new RConnection("localhost", 6311);	
		  println("3")		
		  println("Connected to R")
		  Consigparameters.executeUpdate("update Consigparameters b set b.status=:status " +
                      "where b.uuid=:uuid",
                      [status: 'running', uuid: uuid])
		  connection.voidEval("library('gplots')");
		  Consigparameters.executeUpdate("update Consigparameters b set b.status=:status " +
                      "where b.uuid=:uuid",
                      [status: 'done', uuid: uuid])
                      
                      
		  println("4")		  
		  println("done with the Rserve")
          
			     
          
         }
          
    }
    
    
    void checkForScheduledTasks() {
    

    
	}
}
