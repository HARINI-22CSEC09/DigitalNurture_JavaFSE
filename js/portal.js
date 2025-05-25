// 1. JavaScript Basics
console.log("Welcome to the Community Portal");
window.onload = () => {
  alert("📢 Page is fully loaded. Welcome!");
};

// Sample Event Data
const events = [
  {
    name: "Music Festival",
    date: "2025-06-15",
    location: "downtown",
    category: "music",
    seats: 50,
  },
  {
    name: "Cooking Workshop",
    date: "2025-07-01",
    location: "center",
    category: "workshop",
    seats: 0,
  },
  {
    name: "Sports Day",
    date: "2025-06-25",
    location: "park",
    category: "sports",
    seats: 10,
  },
  {
    name: "Community Meetup",
    date: "2025-06-10",
    location: "center",
    category: "community",
    seats: 5,
  }
];

// 2. Render Events
function renderEvents(eventList = events) {
  const container = document.getElementById("eventsContainer");
  container.innerHTML = "";
  const today = new Date();

  eventList.forEach(event => {
    const eventDate = new Date(event.date);
    if (eventDate >= today && event.seats > 0) {
      const card = document.createElement("div");
      card.className = "eventCard";

      card.innerHTML = `
        <div class="event-image">🎈</div>
        <h3 class="event-title">${event.name}</h3>
        <p class="event-details">${event.date} - ${event.location}</p>
        <p class="event-seats ${event.seats === 0 ? 'full' : event.seats < 10 ? 'low' : ''}">
          ${event.seats === 0 ? "Full" : event.seats + " Seats Left"}
        </p>
        <button class="register-btn" onclick="registerUser('${event.name}')">Register</button>
      `;
      container.appendChild(card);
    }
  });
}

renderEvents();

// 3. Event Registration
function registerUser(eventName) {
  const event = events.find(e => e.name === eventName);
  try {
    if (!event || event.seats <= 0) {
      throw new Error("❌ No seats available for this event.");
    }
    event.seats--;
    alert(`✅ Registered for ${event.name}.`);
    renderEvents();
  } catch (error) {
    alert(error.message);
  }
}

// 4. Category Filter
function filterByCategory() {
  const cat = document.getElementById("categoryFilter").value;
  const filtered = cat ? events.filter(e => e.category === cat) : events;
  renderEvents(filtered);
}

// 5. Location Filter
function filterByLocation() {
  const loc = document.getElementById("locationFilter").value;
  const filtered = loc ? events.filter(e => e.location === loc) : events;
  renderEvents(filtered);
}

// 6. Search by Name
function handleQuickSearch(e) {
  if (e.key === "Enter") {
    const text = e.target.value.toLowerCase();
    const results = events.filter(e => e.name.toLowerCase().includes(text));
    renderEvents(results);
  }
}

// 7. Event Fee Display
function showEventFee() {
  const type = document.getElementById("eventType").value;
  const feeOutput = document.getElementById("eventFee");

  let fee = 0;
  switch (type) {
    case "music": fee = 100; break;
    case "workshop": fee = 50; break;
    case "sports": fee = 30; break;
    case "community": fee = 0; break;
  }

  feeOutput.textContent = `💵 Event Fee: ₹${fee}`;
}

// 8. Character Counter
function countCharacters() {
  const text = document.getElementById("feedback").value;
  document.getElementById("charCounter").textContent = `${text.length} characters`;
}

// 9. Form Validation
function validateName() {
  const name = document.getElementById("userName").value;
  const error = document.getElementById("nameError");
  error.textContent = name.trim().length < 3 ? "❌ Name must be at least 3 characters." : "";
}

function validateEmail() {
  const email = document.getElementById("userEmail").value;
  const error = document.getElementById("emailError");
  const pattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  error.textContent = !pattern.test(email) ? "❌ Enter a valid email." : "";
}

function validatePhone() {
  const phone = document.getElementById("userPhone").value;
  const error = document.getElementById("phoneError");
  error.textContent = phone && phone.length < 10 ? "❌ Phone number is too short." : "";
}

// 10. Form Submission
function handleFormSubmit(e) {
  e.preventDefault();
  validateName();
  validateEmail();
  validatePhone();

  const name = document.getElementById("userName").value;
  const email = document.getElementById("userEmail").value;
  const output = document.getElementById("formOutput");

  output.innerHTML = `✅ Thank you, ${name}! Confirmation sent to ${email}.`;
}

// 11. Modal Image Viewer
function enlargeImage(img) {
  const modal = document.getElementById("imageModal");
  const modalImg = document.getElementById("modalImage");
  modal.style.display = "block";
  modalImg.src = img.src;
  modalImg.alt = img.alt;
}

function closeModal() {
  document.getElementById("imageModal").style.display = "none";
}

// 12. Geolocation Feature
function findNearbyEvents() {
  const geoResult = document.getElementById("geoResult");
  geoResult.innerHTML = "🔄 Locating...";

  if (!navigator.geolocation) {
    geoResult.innerHTML = "❌ Geolocation not supported.";
    return;
  }

  navigator.geolocation.getCurrentPosition(pos => {
    const { latitude, longitude } = pos.coords;
    geoResult.innerHTML = `📍 Your location: (${latitude.toFixed(2)}, ${longitude.toFixed(2)})`;
  }, err => {
    geoResult.innerHTML = `❌ Error: ${err.message}`;
  });
}

// 13. Preferences Storage
function savePreferences() {
  const name = document.getElementById("userName").value;
  localStorage.setItem("preferredName", name);
  document.getElementById("preferenceStatus").textContent = "✅ Preferences saved.";
}

function loadPreferences() {
  const name = localStorage.getItem("preferredName");
  if (name) {
    document.getElementById("userName").value = name;
    document.getElementById("preferenceStatus").textContent = "📂 Preferences loaded.";
  } else {
    document.getElementById("preferenceStatus").textContent = "⚠️ No preferences found.";
  }
}

function clearPreferences() {
  localStorage.clear();
  document.getElementById("preferenceStatus").textContent = "🗑️ Preferences cleared.";
}

// 14. Video Interaction
function showVideoReady() {
  document.getElementById("videoStatus").textContent = "🎬 Video is ready to play.";
}

function warnBeforeLeave() {
  return "You are about to leave the page.";
}

// 15. Confirmation Button
function confirmRegistration() {
  alert("✅ Please confirm your registration details before submitting.");
}
