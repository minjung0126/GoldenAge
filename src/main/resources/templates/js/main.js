let target = document.querySelector("#dynamic");

/** 출력할 배열 함수 */
function randomString() {
  let stringArr = [
    "WE ARE GOLDEN AGE",
    "WE MAKE FUTURE",
    "WE MAKE NEW GENERATION",
  ];

  let selectString = stringArr[Math.floor(Math.random() * stringArr.length)];
  let selectStringArr = selectString.split("");

  return selectStringArr;
}

/** 타이핑 리셋 */
function resetTyping() {
  target.textContent = "";
  dynamic(randomString());
}

/** 한글자 씩 텍스트 출력 함수 */
function dynamic(randomArr) {
  if (randomArr.length > 0) {
    target.textContent += randomArr.shift();
    setTimeout(function () {
      dynamic(randomArr);
    }, 80);
  } else {
    setTimeout(resetTyping, 3000);
  }
}

dynamic(randomString());

/** 커서 깜빡임 처리 */
function blink() {
  target.classList.toggle("active");
}
setInterval(blink, 500);

/**
 * Scroll top 버튼
 */
const scrollTop = document.querySelector(".scroll-top");
if (scrollTop) {
  const togglescrollTop = function () {
    window.scrollY > 100
      ? scrollTop.classList.add("active")
      : scrollTop.classList.remove("active");
  };
  window.addEventListener("load", togglescrollTop);
  document.addEventListener("scroll", togglescrollTop);
  scrollTop.addEventListener(
    "click",
    window.scrollTo({
      top: 0,
      behavior: "smooth",
    })
  );
}
