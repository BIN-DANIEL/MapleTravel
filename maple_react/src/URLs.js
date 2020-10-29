function URLs() {
    this.root = "http://localhost:8082/";
    this.loginURL = this.root + "login";
    this.hasUserURL = this.root + "hasUser";
    this.signUpURL = this.root + "register";
    this.buildHasUserURL = (username) => {
        return this.hasUserURL + "?username=" + username;
    }
}
export default new URLs();