var page = require('webpage').create();

page.open('http://localhost:8080/', function (s) {
    console.log(s);

    // Mocha / Chai tests
    describe("DOM Tests", function () {

      var myEl = document.getElementById('myDiv');
      it("is in the DOM", function () {
          expect(myEl).to.not.equal(null);
      });

      it("is a child of the body", function () {
          expect(myEl.parentElement).to.equal(document.body);
      });

      it("has the right text", function () {
          expect(myEl.innerHTML).to.equal("Hi there!");
      });

      it("has the right background", function () {
          expect(myEl.style.background).to.equal("rgb(204, 204, 204)");
      });
  });

    phantom.exit();
});
