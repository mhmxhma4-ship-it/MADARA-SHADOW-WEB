export default function TokensPage() {
  return (
    <main className="madara-container">
      <p className="madara-red">ACCESS MANAGEMENT</p>
      <h1 className="madara-title">MY TOKENS</h1>
      <p style={{ color: "#999", marginTop: 12 }}>
        Manage your MADARA SHADOW access tokens.
      </p>

      <section className="madara-card" style={{ marginTop: 35 }}>
        <div style={{ display: "flex", justifyContent: "space-between", flexWrap: "wrap", gap: 12 }}>
          <div>
            <h2 style={{ fontSize: 23, fontWeight: 900 }}>YOUR ACCESS TOKENS</h2>
            <p style={{ color: "#999", marginTop: 8 }}>Total tokens: 0</p>
          </div>
          <span className="madara-red">NO ACTIVE TOKENS</span>
        </div>

        <div style={{ borderTop: "1px solid #333", marginTop: 25, paddingTop: 25 }}>
          <p style={{ color: "#aaa" }}>You do not have any access tokens yet.</p>
          <p style={{ color: "#777", fontSize: 13, marginTop: 10 }}>
            Token generation and activation will be available after the access system is connected.
          </p>
        </div>
      </section>

      <section className="madara-card" style={{ marginTop: 22 }}>
        <h2 style={{ fontSize: 20, fontWeight: 900 }}>TOKEN SECURITY</h2>
        <p style={{ color: "#999", marginTop: 12 }}>
          Your tokens will be managed securely and linked to your account.
        </p>
      </section>
    </main>
  );
}
