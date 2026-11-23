import Link from "next/link";

export default function SupportPage() {
  return (
    <main className="madara-container">
      <p className="madara-red">WE ARE HERE TO HELP</p>
      <h1 className="madara-title">SUPPORT CENTER</h1>
      <p style={{ color: "#999", marginTop: 12 }}>
        Need help with your MADARA SHADOW account?
      </p>

      <section className="madara-card" style={{ maxWidth: 650, marginTop: 35 }}>
        <h2 style={{ fontSize: 24, fontWeight: 900 }}>CONTACT SUPPORT</h2>

        <form style={{ marginTop: 25 }}>
          <label>Your name</label>
          <input className="madara-input" type="text" placeholder="Your name" required />

          <label>Email address</label>
          <input className="madara-input" type="email" placeholder="name@example.com" required />

          <label>Subject</label>
          <input className="madara-input" type="text" placeholder="How can we help?" required />

          <label>Message</label>
          <textarea
            className="madara-input"
            placeholder="Describe your problem..."
            rows={5}
            required
          />

          <button className="madara-button" type="button" style={{ width: "100%" }}>
            SEND MESSAGE
          </button>
        </form>

        <p style={{ color: "#777", fontSize: 12, marginTop: 18 }}>
          Support message delivery will be activated after backend integration.
        </p>
      </section>

      <p style={{ marginTop: 25, color: "#999" }}>
        Return to <Link href="/dashboard" className="madara-red">Dashboard</Link>
      </p>
    </main>
  );
}
