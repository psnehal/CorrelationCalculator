package testconsig1

class SubmitJobJob {

	def retrieveSubmittedJobsService
	 
    static triggers = {
        simple name: 'simpleTrigger', startDelay: 10000, repeatInterval: 30000, repeatCount: 10
       
    }

    void execute() {
        println "Job run!"
        def list_jobs= retrieveSubmittedJobsService.listalljobs()
        println (list_jobs)
    }
}
