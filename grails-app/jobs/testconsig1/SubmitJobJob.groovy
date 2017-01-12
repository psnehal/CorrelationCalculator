package testconsig1

class SubmitJobJob {

	def retrieveSubmittedJobsService
	 
    static triggers = {
        simple name: 'simpleTrigger', startDelay: 10000, repeatInterval: 120000
       
    }

    void execute() {
      println "Job started!"
        def list_jobs= retrieveSubmittedJobsService.listalljobs()
       println ("Job Finished")
    }
}
