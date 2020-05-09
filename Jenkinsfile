node ('linux') {
  
   stage('Checkout') {
     git 'https://github.com/duotechacademy/duotify'  
       
   }
   
   try{
   stage('Build and Test') {
      bat label: '', script: 'mvn verify -Dcucumber.filter.tags="@db"' 
       
   
   }
   }catch (Exception e){
       echo "Build failed"
   }
   stage('Report') {
       cucumber failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/*.json', pendingStepsNumber: -1, skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1
       junit '**/*Cucumber.xml' 
       
   }
   stage('Email') {
       step([$class: 'Mailer', notifyEveryUnstableBuild: true, recipients: 'duotechinstructor@gmail.com akmal2029970699@gmail.com', sendToIndividuals: false])
       
   }
   
   
}
