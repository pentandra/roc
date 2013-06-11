$(function() {
  var mainNav = $('.header-container .nav-background');
  var mainNavTop = mainNav.offset().top;
  var $window = $(window);

  var ifScrollingBelowLogo = function() {
    return $window.scrollTop() > mainNavTop;
  }
  
  $window.scroll(function() {
    mainNav.toggleClass('pinned', ifScrollingBelowLogo());
  });
});
