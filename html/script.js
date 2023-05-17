// Selecciona el elemento con el id "menu-icon" y lo asigna a la variable "menu"
let menu = document.querySelector('#menu-icon');

// Selecciona el elemento con la clase "navlist" y lo asigna a la variable "navlist"
let navlist = document.querySelector('.navlist');

// Agrega un evento de clic al elemento "menu"
menu.onclick = () => {
    // Agrega o elimina la clase "bx-x" del elemento "menu"
    menu.classList.toggle('bx-x');
    // Agrega o elimina la clase "open" del elemento "navlist"
    navlist.classList.toggle('open');
};

// Crea una instancia de ScrollReveal con ciertas opciones y lo asigna a la variable "sr"
const sr = ScrollReveal ({
    distance: '65px',
    duration: 2600,
    delay:450,
    reset:true
});

// Hace que los elementos con la clase "hero-text" se revelen con un cierto retraso y origen
sr.reveal('.hero-text',{delay:200, origin:'top'});
// Hace que los elementos con la clase "scroll-down" se revelen con un cierto retraso y origen
sr.reveal('.scroll-down',{delay:500, origin:'right'});

// Selecciona el elemento con la clase "wrapper" y lo asigna a la variable "wrapper"
const wrapper = document.querySelector('.wrapper');
// Selecciona el elemento con la clase "login-link" y lo asigna a la variable "loginLink"
const loginLink = document.querySelector('.login-link');
// Selecciona el elemento con la clase "register-link" y lo asigna a la variable "registerLink"
const registerLink = document.querySelector('.register-link');
// Selecciona el elemento con la clase "btnLogin-popup" y lo asigna a la variable "btnPopup"
const btnPopup = document.querySelector('.btnLogin-popup');
// Selecciona el elemento con la clase "icon-close" y lo asigna a la variable "closeBtn"
const closeBtn = document.querySelector('.icon-close');

// Agrega un evento de clic al elemento "registerLink"
registerLink.addEventListener('click',() => {
    // Agrega la clase "active" al elemento "wrapper"
    wrapper.classList.add('active');
});
// Agrega un evento de clic al elemento "btnPopup"
btnPopup.addEventListener('click', () => {
    // Agrega la clase "active-popup" al elemento "wrapper"
    wrapper.classList.add('active-popup');
});
// Agrega un evento de clic al elemento "closeBtn"
closeBtn.addEventListener('click', () => {
    // Elimina la clase "active-popup" del elemento "wrapper"
    wrapper.classList.remove('active-popup');
});

// Agrega un evento de clic al elemento "loginLink"
loginLink.addEventListener('click', (event) => {
    // Elimina la clase "active" del elemento "wrapper"
    wrapper.classList.remove('active');
    // Evita que el enlace redirija a una nueva página
    event.preventDefault();
});

