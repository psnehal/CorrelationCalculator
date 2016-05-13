package testconsig1

import grails.transaction.Transactional

@Transactional
class RetrieveSubmittedJobsService {

    def serviceMethod() {

    }
    
    def listalljobs() {
        println("above query")
        return Consigparameters.executeQuery("from Consigparameters where id>1")
        println("below query")
    }
}
