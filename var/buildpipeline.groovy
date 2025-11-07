
def call(String repoUrl, String branch = 'main') {
    def obj = new com.example.utility()
    obj.cloneRepo(repoUrl, branch)
}
