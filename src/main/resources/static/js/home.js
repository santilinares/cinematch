document.addEventListener("click", e => {
  let handle
  if (e.target.matches(".handle")) {
    handle = e.target
  } else {
    handle = e.target.closest(".handle")
  }
  if (handle != null) onHandleClick(handle)
})

document.addEventListener("DOMContentLoaded", function () {
  const navEl = document.querySelector(".navbar");

  if (navEl) {
    window.addEventListener("scroll", () => {
      if (window.scrollY >= 56) {
        navEl.classList.add("navbar-scrolled")
      } else {
        navEl.classList.remove("navbar-scrolled")
      }
    })
  }
})



const throttleProgressBar = throttle(() => {
  document.querySelectorAll(".progress-bar").forEach(calculateProgressBar)
}, 250)
window.addEventListener("resize", throttleProgressBar)

document.querySelectorAll(".progress-bar").forEach(calculateProgressBar)

function calculateProgressBar(progressBar) {
  progressBar.innerHTML = ""
  const slider = progressBar.closest(".row").querySelector(".slider")
  const itemCount = slider.children.length
  const itemsPerScreen = parseInt(
    getComputedStyle(slider).getPropertyValue("--items-per-screen")
  )
  let sliderIndex = parseInt(
    getComputedStyle(slider).getPropertyValue("--slider-index")
  )
  const progressBarItemCount = Math.ceil(itemCount / itemsPerScreen)

  if (sliderIndex >= progressBarItemCount) {
    slider.style.setProperty("--slider-index", progressBarItemCount - 1)
    sliderIndex = progressBarItemCount - 1
  }

  for (let i = 0; i < progressBarItemCount; i++) {
    const barItem = document.createElement("div")
    barItem.classList.add("progress-item")
    if (i === sliderIndex) {
      barItem.classList.add("active")
    }
    progressBar.append(barItem)
  }
}

function onHandleClick(handle) {
  const progressBar = handle.closest(".row").querySelector(".progress-bar")
  const slider = handle.closest(".container").querySelector(".slider")
  const sliderIndex = parseInt(
    getComputedStyle(slider).getPropertyValue("--slider-index")
  )
  const progressBarItemCount = progressBar.children.length
  if (handle.classList.contains("left-handle")) {
    if (sliderIndex - 1 < 0) {
      slider.style.setProperty("--slider-index", progressBarItemCount - 1)
      progressBar.children[sliderIndex].classList.remove("active")
      progressBar.children[progressBarItemCount - 1].classList.add("active")
    } else {
      slider.style.setProperty("--slider-index", sliderIndex - 1)
      progressBar.children[sliderIndex].classList.remove("active")
      progressBar.children[sliderIndex - 1].classList.add("active")
    }
  }

  if (handle.classList.contains("right-handle")) {
    if (sliderIndex + 1 >= progressBarItemCount) {
      slider.style.setProperty("--slider-index", 0)
      progressBar.children[sliderIndex].classList.remove("active")
      progressBar.children[0].classList.add("active")
    } else {
      slider.style.setProperty("--slider-index", sliderIndex + 1)
      progressBar.children[sliderIndex].classList.remove("active")
      progressBar.children[sliderIndex + 1].classList.add("active")
    }
  }
}

function throttle(cb, delay = 1000) {
  let shouldWait = false
  let waitingArgs
  const timeoutFunc = () => {
    if (waitingArgs == null) {
      shouldWait = false
    } else {
      cb(...waitingArgs)
      waitingArgs = null
      setTimeout(timeoutFunc, delay)
    }
  }

  return (...args) => {
    if (shouldWait) {
      waitingArgs = args
      return
    }

    cb(...args)
    shouldWait = true
    setTimeout(timeoutFunc, delay)
  }
}

//To show a feedback alert to the user when they try to log in
document.getElementById("login").addEventListener("click", function(event) {
  event.preventDefault(); // Prevent the default form submission

  // Get form data
  var formData = new FormData(document.getElementById("loginForm"));

  // Make a POST request to the server
  fetch("/api/user/getuser", {
    method: "POST",
    body: formData
  })
  .then(function(response) {
    if (response.ok) {
      // Response status is 200, show the alert
      alert("Login successful!");
    } else {
      // Response status is not 200, handle the error
      alert("Email or password are not correct.");
    }
  })
  .catch(function(error) {
    // An error occurred during the fetch
    console.error("Error:", error);
  });
});

//To allow the PUT operation for Film entity
document.getElementById('updateFilmForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent the normal submission of the form

    var formData = new FormData(this);
    var object = {};
    formData.forEach(function(value, key) {
        object[key] = value;
    });
    var json = JSON.stringify(object);

    fetch('/api/film/', {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: json
    }).then(response => {
        if (response.ok) {
            return response.json();
        }
        throw new Error('Something went wrong');
    }).then(data => {
        console.log(data);
        // Handle success
    }).catch(error => {
        console.error('Error:', error);
    });
});

