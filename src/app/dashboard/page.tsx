import Link from "next/link";

const stats = [
  { title: "ACCOUNT STATUS", value: "NOT CONNECTED" },
  { title: "ACTIVE TOKENS", value: "0" },
  { title: "AVAILABLE SERVICES", value: "COMING SOON" },
];

export default function DashboardPage() {
  return (
    <main className="madara-container">
      <p className="madara-red">USER CONTROL CENTER</p>
      <h1 className="madara-title">DASHBOARD</h1>
      <p style={{ color: "#999", marginTop: 12 }}>
        Manage your MADARA SHADOW account and access.
      </p>

      <section style={{
        display: "grid",
        gridTemplateColumns: "repeat(auto-fit, minmax(210px, 1fr))",
        gap: 18,
        marginTop: 35
      }}>
        {stats.map((stat) => (
          <div className="madara-card" key={stat.title}>
            <p className="madara-red">{stat.title}</p>
            <h2 style={{ fontSize: 22, marginTop: 15 }}>{stat.value}</h2>
          </div>
        ))}
      </section>

      <section className="madara-card" style={{ marginTop: 25 }}>
        <h2 style={{ fontSize: 24, fontWeight: 900 }}>QUICK ACTIONS</h2>
        <div style={{ display: "flex", flexWrap: "wrap", gap: 12, marginTop: 22 }}>
          <Link className="madara-button" href="/tokens">MY TOKENS</Link>
          <Link className="madara-button" href="/support">GET SUPPORT</Link>
          <Link className="madara-button" href="/login">LOGIN</Link>
        </div>
      </section>
    </main>
  );
}
