const sections = [
  { title: "TOTAL USERS", value: "0", detail: "Registered accounts" },
  { title: "ACTIVE TOKENS", value: "0", detail: "Currently activated" },
  { title: "TOTAL SERVICES", value: "0", detail: "Available services" },
  { title: "SUPPORT TICKETS", value: "0", detail: "Open requests" },
];

export default function AdminPage() {
  return (
    <main className="madara-container">
      <p className="madara-red">SYSTEM CONTROL</p>
      <h1 className="madara-title">ADMIN PANEL</h1>
      <p style={{ color: "#999", marginTop: 12 }}>
        MADARA SHADOW administration center.
      </p>

      <section style={{
        display: "grid",
        gridTemplateColumns: "repeat(auto-fit, minmax(200px, 1fr))",
        gap: 18,
        marginTop: 35
      }}>
        {sections.map((item) => (
          <div className="madara-card" key={item.title}>
            <p className="madara-red">{item.title}</p>
            <h2 style={{ fontSize: 34, marginTop: 14 }}>{item.value}</h2>
            <p style={{ color: "#888", fontSize: 13, marginTop: 8 }}>{item.detail}</p>
          </div>
        ))}
      </section>

      <section className="madara-card" style={{ marginTop: 25 }}>
        <h2 style={{ fontSize: 23, fontWeight: 900 }}>MANAGEMENT</h2>

        {[
          "USER MANAGEMENT",
          "TOKEN MANAGEMENT",
          "SERVICE MANAGEMENT",
          "SUPPORT MANAGEMENT",
          "SYSTEM SETTINGS",
        ].map((item) => (
          <div key={item} style={{
            padding: 17,
            marginTop: 12,
            background: "#080808",
            border: "1px solid #292929",
            borderRadius: 7,
            fontWeight: 800
          }}>
            {item}
            <span className="madara-red" style={{ float: "right" }}>COMING SOON</span>
          </div>
        ))}
      </section>
    </main>
  );
}
