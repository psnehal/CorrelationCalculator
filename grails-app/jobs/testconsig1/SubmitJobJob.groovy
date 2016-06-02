package testconsig1

class SubmitJobJob {

	def retrieveSubmittedJobsService
	 
    static triggers = {
        simple name: 'simpleTrigger', startDelay: 10000, repeatInterval: 300000
       
    }

    void execute() {
        println "Job run!"
        def list_jobs= retrieveSubmittedJobsService.listalljobsCorrelation()
        println (list_jobs)
    }
}
