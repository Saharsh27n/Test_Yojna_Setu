import { NavLink } from 'react-router-dom'
import { Home, MessageCircle, FileText, Radio, User } from 'lucide-react'
import { useScrollPosition } from '../lib/hooks'
import './Navbar.css'

const NAV_ITEMS = [
    { to: '/home', label: 'Home', Icon: Home },
    { to: '/chat', label: 'Sathi', Icon: MessageCircle },
    { to: '/schemes', label: 'Schemes', Icon: FileText },
    { to: '/status', label: 'Status', Icon: Radio },
    { to: '/profile', label: 'Profile', Icon: User },
]

/* Top navigation for desktop */
export function Navbar() {
    const scrollPos = useScrollPosition()
    const isScrolled = scrollPos > 20

    return (
        <nav className={`navbar ${isScrolled ? 'scrolled' : ''}`}>
            <NavLink to="/home" className="navbar-logo">
                <div className="logo-img-circle">
                    <img src="/logo.png" alt="Yojna Setu" className="logo-img" />
                </div>
            </NavLink>
            <div className="navbar-links">
                {NAV_ITEMS.map(({ to, label }) => (
                    <NavLink key={to} to={to} className={({ isActive }) => `nav-link ${isActive ? 'active' : ''}`}>
                        {label}
                    </NavLink>
                ))}
            </div>
        </nav>
    )
}

/* Bottom tab bar for mobile */
export function BottomNav() {
    return (
        <nav className="bottom-nav">
            {NAV_ITEMS.map((item) => {
                const NavIcon = item.Icon
                return (
                    <NavLink key={item.to} to={item.to} className={({ isActive }) => `bottom-nav-item ${isActive ? 'active' : ''}`}>
                        <NavIcon size={20} />
                        <span>{item.label}</span>
                    </NavLink>
                )
            })}
        </nav>
    )
}
