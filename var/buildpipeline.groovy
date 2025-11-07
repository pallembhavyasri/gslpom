
def call(String repoUrl, String branch = 'main') {
    def obj = new com.example.utility(this)
    obj.cloneRepo(repoUrl, branch)
}
