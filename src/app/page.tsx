const features = [
  {
    id: "01",
    title: "SECURE ACCESS",
    description: "Advanced access control and personal security tokens.",
  },
  {
    id: "02",
    title: "USER DASHBOARD",
    description: "Manage your account and access from one place.",
  },
  {
    id: "03",
    title: "ADMIN CONTROL",
    description: "Manage users, tokens and platform activity.",
  },
];

export default function Home() {
  return (
    <main className="min-h-screen overflow-hidden bg-[#070707] text-white">
      <nav className="mx-auto flex max-w-7xl items-center justify-between px-6 py-7">
        <div className="text-xl font-black tracking-widest">
          <span className="text-red-600">MADARA</span> SHADOW
        </div>
        <a href="#features" className="border border-red-700 px-5 py-3 text-xs font-bold tracking-widest hover:bg-red-700">
          EXPLORE
        </a>
      </nav>

      <section className="relative flex min-h-[75vh] flex-col items-center justify-center px-6 text-center">
        <div className="absolute h-96 w-96 rounded-full bg-red-700/20 blur-[130px]" />
        <div className="relative">
          <p className="mb-8 text-xs font-bold tracking-[0.4em] text-red-500">
            THE SHADOW EXPERIENCE
          </p>
          <h1 className="text-6xl font-black tracking-tight sm:text-8xl">
            MADARA
            <span className="block text-red-600">SHADOW</span>
          </h1>
          <p className="mx-auto mt-8 max-w-xl text-sm leading-7 text-zinc-400 sm:text-base">
            Your platform. Your access. Your control.
            Welcome to the official MADARA SHADOW ecosystem.
          </p>
          <div className="mt-10 flex flex-wrap justify-center gap-4">
            <a href="#features" className="bg-red-600 px-8 py-4 text-xs font-black tracking-widest shadow-lg shadow-red-900/30 hover:bg-red-500">
              EXPLORE PLATFORM
            </a>
            <a href="#about" className="border border-zinc-700 px-8 py-4 text-xs font-bold tracking-widest hover:border-red-600">
              LEARN MORE
            </a>
          </div>
        </div>
      </section>

      <section id="about" className="border-y border-white/10 bg-[#0c0c0c] px-6 py-20 text-center">
        <p className="text-xs font-bold tracking-[0.35em] text-red-500">OUR ECOSYSTEM</p>
        <h2 className="mt-5 text-3xl font-black sm:text-5xl">
          ONE PLATFORM. <span className="text-red-600">TOTAL CONTROL.</span>
        </h2>
        <p className="mx-auto mt-6 max-w-2xl text-sm leading-7 text-zinc-500">
          A central platform for secure access, account management and administration.
        </p>
      </section>

      <section id="features" className="mx-auto max-w-7xl px-6 py-24">
        <p className="text-xs font-bold tracking-[0.3em] text-red-500">FEATURES</p>
        <h2 className="mt-4 text-4xl font-black">BUILT FOR CONTROL</h2>
        <div className="mt-12 grid gap-6 md:grid-cols-3">
          {features.map((feature) => (
            <article key={feature.id} className="rounded-xl border border-white/10 bg-[#101010] p-8 transition hover:-translate-y-1 hover:border-red-700">
              <span className="text-sm font-black text-red-600">/{feature.id}</span>
              <h3 className="mt-8 text-lg font-black">{feature.title}</h3>
              <p className="mt-4 text-sm leading-7 text-zinc-500">{feature.description}</p>
              <div className="mt-8 h-1 w-12 bg-red-700" />
            </article>
          ))}
        </div>
      </section>

      <footer className="border-t border-white/10 px-6 py-8 text-center text-xs text-zinc-600">
        <span className="font-black tracking-widest text-white">
          <span className="text-red-600">MADARA</span> SHADOW
        </span>
        <p className="mt-3">© 2026 MADARA SHADOW. All rights reserved.</p>
      </footer>
    </main>
  );
}
