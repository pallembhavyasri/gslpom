
def call() {
    if(JOB_NAME.contains("3-repos")){
    def obj1 = new com.example.replay()
    obj1.reposClone()
}
    else if(JOB_NAME.contains("test")){
        def obj = new com.example.test()
        obj.test1()
    }
}
