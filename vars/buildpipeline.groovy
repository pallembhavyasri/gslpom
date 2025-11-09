
def call() {
    if(JOB_NAME.contains("3-repos")){
    def obj1 = new com.example.replay()
    obj1.reposClone()
}
    else if(JOB_NAME.contains("test")){
        def obj = new com.example.test()
        obj.test1()
    }
    else if(JOB_NAME.contains("sub-folder")){
        def obj2 = new com.example.subfolder()
        obj.createDelete()
    }
}

