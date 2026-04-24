import React from 'react'
import './components.css'

/**
 * Animated SVG Ashoka Chakra / Mandala Logo
 */
export function MandalaLogo() {
    return (
        <div className="mandala-wrapper">
            <svg className="mandala-svg" viewBox="0 0 120 120" fill="none" xmlns="http://www.w3.org/2000/svg">
                {/* Outer ring */}
                <circle cx="60" cy="60" r="55" stroke="rgba(232,141,10,0.25)" strokeWidth="1" />
                <circle cx="60" cy="60" r="48" stroke="rgba(232,141,10,0.15)" strokeWidth="0.5" />
                {/* Inner ring */}
                <circle cx="60" cy="60" r="18" stroke="rgba(232,141,10,0.6)" strokeWidth="1.5" fill="rgba(232,141,10,0.06)" />
                {/* Center dot */}
                <circle cx="60" cy="60" r="4" fill="#e88d0a" opacity="0.9" />
                {/* 24 Spokes (Ashoka Chakra) */}
                {Array.from({ length: 24 }).map((_, i) => {
                    const angle = (i * 360) / 24
                    const rad = (angle * Math.PI) / 180
                    const x1 = 60 + 18 * Math.cos(rad)
                    const y1 = 60 + 18 * Math.sin(rad)
                    const x2 = 60 + 48 * Math.cos(rad)
                    const y2 = 60 + 48 * Math.sin(rad)
                    return (
                        <line
                            key={i}
                            x1={x1} y1={y1} x2={x2} y2={y2}
                            stroke={i % 2 === 0 ? 'rgba(232,141,10,0.7)' : 'rgba(232,141,10,0.3)'}
                            strokeWidth={i % 2 === 0 ? '1.2' : '0.6'}
                        />
                    )
                })}
                {/* Decorative dots on outer ring */}
                {Array.from({ length: 8 }).map((_, i) => {
                    const angle = (i * 360) / 8
                    const rad = (angle * Math.PI) / 180
                    const x = 60 + 55 * Math.cos(rad)
                    const y = 60 + 55 * Math.sin(rad)
                    return <circle key={i} cx={x} cy={y} r="2.5" fill="rgba(232,141,10,0.6)" />
                })}
                {/* Glow in center */}
                <circle cx="60" cy="60" r="10" fill="rgba(232,141,10,0.1)" />
            </svg>
            <div className="mandala-glow-ring" />
        </div>
    )
}

/**
 * Custom Sathi AI Avatar SVG
 */
export function SathiAvatar({ size = 28 }) {
    return (
        <svg viewBox="0 0 60 60" fill="none" xmlns="http://www.w3.org/2000/svg" width={size} height={size}>
            <circle cx="30" cy="22" r="10" fill="rgba(232,141,10,0.9)" />
            <circle cx="30" cy="22" r="6" fill="#0d0e1c" />
            <circle cx="27" cy="20" r="2" fill="#e88d0a" />
            <circle cx="33" cy="20" r="2" fill="#e88d0a" />
            <rect x="18" y="35" width="24" height="16" rx="4" fill="rgba(232,141,10,0.8)" />
            <rect x="22" y="40" width="4" height="6" rx="1" fill="#0d0e1c" />
            <rect x="34" y="40" width="4" height="6" rx="1" fill="#0d0e1c" />
            <line x1="30" y1="32" x2="30" y2="35" stroke="rgba(232,141,10,0.8)" strokeWidth="2" />
        </svg>
    )
}
