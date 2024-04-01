document.addEventListener("DOMContentLoaded", function() {
    const navEl = document.querySelector(".navbar");
    
    if (navEl) {
        window.addEventListener("scroll", () => {
            if (window.scrollY >= 56) {
                navEl.classList.add("navbar-scrolled");
            } else {
                navEl.classList.remove("navbar-scrolled");
            }
        });
    } else {
        console.error("Navbar element not found.");
    }
});
