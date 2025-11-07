
def call(String repoUrl, String branch = 'main') {
    def obj = new com.example.test()
    //obj.cloneRepo(repoUrl, branch)
    obj.test1(repoUrl, branch)
}
