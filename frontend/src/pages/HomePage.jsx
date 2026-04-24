import { useNavigate } from 'react-router-dom'
import { Mic, MessageCircle, ArrowRight, Sparkles } from 'lucide-react'
import { Navbar, BottomNav } from '../components/Navbar'
import { MandalaLogo, SathiAvatar } from '../components/Icons'
import { SCHEME_CATEGORIES } from '../lib/constants'
import '../components/components.css'
import './HomePage.css'

export default function HomePage() {
    const navigate = useNavigate()

    return (
        <div className="page-wrapper home-wrapper">
            {/* Premium Aurora Animated Background */}
            <div className="home-bg-aurora">
                <div className="aurora-orb orb-1" />
                <div className="aurora-orb orb-2" />
                <div className="aurora-orb orb-3" />
                <div className="aurora-orb orb-4" />
            </div>

            <Navbar />
            <main className="home-main">

                {/* ── Hero ── */}
                <section className="home-hero-cultural">
                    <div className="hero-bg-rays" />
                    <MandalaLogo />
                    <h1 className="hero-title-cultural">
                        Namaste, <span className="hero-title-saffron">Bharat</span>
                    </h1>
                    <p className="hero-dharma-line">Seva Hi Dharma &nbsp;·&nbsp; Service Is Duty</p>
                    <div className="hero-btns">
                        <button className="btn-cultural-primary" onClick={() => navigate('/chat')}>
                            Find My Scheme
                        </button>
                        <button className="btn-cultural-outline" onClick={() => navigate('/schemes')}>
                            Explore All
                        </button>
                    </div>
                </section>

                <div className="home-lower-section">
                    {/* ── Meet Sathi AI ── */}
                    <section className="sathi-cultural-card">
                        <div className="sathi-tag"><Sparkles size={10} /> Personal Guide</div>
                        <div className="sathi-card-inner">
                            <div className="sathi-avatar-cultural">
                                <svg viewBox="0 0 60 60" fill="none" xmlns="http://www.w3.org/2000/svg" width="40" height="40">
                                    <circle cx="30" cy="22" r="10" fill="rgba(232,141,10,0.9)" />
                                    <circle cx="30" cy="22" r="6" fill="#0d0e1c" />
                                    <circle cx="27" cy="20" r="2" fill="#e88d0a" />
                                    <circle cx="33" cy="20" r="2" fill="#e88d0a" />
                                    <rect x="18" y="35" width="24" height="16" rx="4" fill="rgba(232,141,10,0.8)" />
                                    <rect x="22" y="40" width="4" height="6" rx="1" fill="#0d0e1c" />
                                    <rect x="34" y="40" width="4" height="6" rx="1" fill="#0d0e1c" />
                                    <line x1="30" y1="32" x2="30" y2="35" stroke="rgba(232,141,10,0.8)" strokeWidth="2" />
                                </svg>
                            </div>
                            <div className="sathi-card-body">
                                <h2 className="sathi-card-title">Meet Sathi AI</h2>
                                <p className="sathi-card-desc">
                                    Your AI guide for government schemes — ask in any Indian language about eligibility, documents, and how to apply.
                                </p>
                            </div>
                            <div className="sathi-card-btns">
                                <button className="btn-cultural-primary sathi-btn" onClick={() => navigate('/chat')}>
                                    <MessageCircle size={13} /> Chat Now
                                </button>
                                <button className="btn-cultural-ghost" onClick={() => navigate('/chat')}>
                                    <Mic size={13} /> Voice
                                </button>
                            </div>
                        </div>
                    </section>

                    {/* ── Categories ── */}
                    <section className="home-cat-section">
                        <div className="home-cat-heading">
                            <p className="cat-heading-eyebrow">सरकारी योजनाएं</p>
                            <h2 className="cat-heading-main">Yojna <span className="cat-heading-saffron">Categories</span></h2>
                            <div className="cat-heading-line" />
                        </div>
                        <div className="home-cat-grid-cultural">
                            {SCHEME_CATEGORIES.map((cat) => (
                                <div key={cat.label} className="cat-card-cultural" onClick={() => navigate(`/schemes?category=${cat.link}`)}>
                                    <div className="cat-card-top">
                                        <div className="cat-icon-wrap">{cat.icon}</div>
                                        <span className="cat-card-count">{cat.count}</span>
                                    </div>
                                    <div className="cat-card-label">{cat.label}</div>
                                    <div className="cat-card-sub">{cat.sub}</div>
                                    <p className="cat-card-desc">{cat.desc}</p>
                                    <div className="cat-card-link">View {cat.sub} <ArrowRight size={11} /></div>
                                </div>
                            ))}
                        </div>
                    </section>
                </div>

                <div style={{ height: 80 }} />
            </main>
            <BottomNav />
        </div>
    )
}
