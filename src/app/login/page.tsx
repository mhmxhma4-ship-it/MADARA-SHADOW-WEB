import Link from "next/link";

export default function LoginPage() {
  return (
    <main className="madara-container">
      <section className="madara-card" style={{ maxWidth: 460, margin: "40px auto" }}>
        <p className="madara-red">WELCOME BACK</p>
        <h1 className="madara-title">LOGIN</h1>
        <p style={{ color: "#999", marginTop: 12 }}>
          Sign in to your MADARA SHADOW account.
        </p>

        <form style={{ marginTop: 30 }}>
          <label>Email address</label>
          <input className="madara-input" type="email" placeholder="name@example.com" required />

          <label>Password</label>
          <input className="madara-input" type="password" placeholder="Enter your password" required />

          <button className="madara-button" type="button" style={{ width: "100%", marginTop: 8 }}>
            SIGN IN
          </button>
        </form>

        <p style={{ color: "#999", marginTop: 24, textAlign: "center" }}>
          Do not have an account?{" "}
          <Link href="/register" className="madara-red">Create account</Link>
        </p>
      </section>
    </main>
  );
}
