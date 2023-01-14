job('ejemplo-job-dsl2'){
  description('job dsl 2 para el curso de jenkins') 
  scm {
        git('https://github.com/lm2a/parametrized.jenkins.job.git', 'main') { node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('lurpiano')
            node / gitConfigEmail('takotaniko@gmail.com')
        }
  }
  parameters{
		stringParam('NOMBRE', defaultValue = 'Mario', description = 'Parametro de cadena para el job')
		choiceParam('PLANETA', ['Mercurio', 'Venus', 'Tierra', 'Marte', 'Jupiter', 'Saturno', 'Urano'])
		booleanParam('AGENTE', false)
	}
  triggers{
  		cron('H/7 * * * *')
  }
  steps{
    shell("bash jobscript.sh")
  }
  
  publishers {
    mailer('lamenza@gmail.com', true, true)
    slackNotifier {
      room('#demo-jenkins-con-slack')
      notifyAborted(true)
      notifyFailure(true)
      notifyNotBuilt(true)
      notifyUnstable(true)
      notifyBackToNormal(true)
      notifySuccess(true)
      notifyRepeatedFailure(false)
      customMessage("Este es mi mensaje de cuando todo fue con alegria!")
      customMessageFailure("Fracaso el build")
      customMessageNotBuilt("No se creo ningun build")
      customMessageSuccess("Aleluya!!!")
      commitInfoChoice('NONE')
     }
  }
}
