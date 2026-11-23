import Link from "next/link";

const links = [
  { name: "HOME", href: "/" },
  { name: "LOGIN", href: "/login" },
  { name: "REGISTER", href: "/register" },
  { name: "DASHBOARD", href: "/dashboard" },
  { name: "MY TOKENS", href: "/tokens" },
  { name: "ADMIN", href: "/admin" },
  { name: "SUPPORT", href: "/support" },
];

export default function Navbar() {
  return (
    <header className="madara-nav">
      <Link href="/" className="madara-logo">
        MADARA<span> SHADOW</span>
      </Link>

      <nav>
        {links.map((link) => (
          <Link key={link.href} href={link.href}>
            {link.name}
          </Link>
        ))}
      </nav>
    </header>
  );
}
