import Link from "next/link";

export default function RegisterPage() {
  return (
    <main className="madara-container">
      <section className="madara-card" style={{ maxWidth: 460, margin: "40px auto" }}>
        <p className="madara-red">JOIN THE SHADOW</p>
        <h1 className="madara-title">REGISTER</h1>
        <p style={{ color: "#999", marginTop: 12 }}>
          Create your MADARA SHADOW account.
        </p>

        <form style={{ marginTop: 30 }}>
          <label>Full name</label>
          <input className="madara-input" type="text" placeholder="Your name" required />

          <label>Email address</label>
          <input className="madara-input" type="email" placeholder="name@example.com" required />

          <label>Password</label>
          <input className="madara-input" type="password" placeholder="Create password" required />

          <label>Confirm password</label>
          <input className="madara-input" type="password" placeholder="Repeat password" required />

          <button className="madara-button" type="button" style={{ width: "100%", marginTop: 8 }}>
            CREATE ACCOUNT
          </button>
        </form>

        <p style={{ color: "#999", marginTop: 24, textAlign: "center" }}>
          Already have an account?{" "}
          <Link href="/login" className="madara-red">Login</Link>
        </p>
      </section>
    </main>
  );
}
