
def call(String repoUrl, String branch = 'main') {
    echo "Hello"
    def obj = new com.example.test()
    echo "HI"
    //obj.cloneRepo(repoUrl, branch)
    obj.test1(repoUrl, branch)
    echo "heyy"
}
