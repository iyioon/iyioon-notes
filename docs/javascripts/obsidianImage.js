document.addEventListener("DOMContentLoaded", function() {
  var images = document.querySelectorAll("img");
  for (var i = 0; i < images.length; i++) {
    var matches = images[i].alt.match(/^(\d+)$/);
    if (matches) {
      images[i].setAttribute('height', matches[1]);
      images[i].setAttribute('width', 'auto');
    }
  }
});

