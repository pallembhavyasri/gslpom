
def call() {
    if(JOB_NAME.contains("3-repos")){
    //def obj = new com.example.test()
    def obj1 = new com.example.replay()
    //obj.cloneRepo(repoUrl, branch)
    //obj.test1(repoUrl, branch)
    obj1.reposClone()
}
}
