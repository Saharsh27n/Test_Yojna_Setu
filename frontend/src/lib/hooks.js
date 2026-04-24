import { useState, useEffect } from 'react'

/**
 * Hook to track window size for responsive UI logic
 */
export function useWindowSize() {
    const [windowSize, setWindowSize] = useState({
        width: typeof window !== 'undefined' ? window.innerWidth : 0,
        height: typeof window !== 'undefined' ? window.innerHeight : 0,
    })

    useEffect(() => {
        function handleResize() {
            setWindowSize({
                width: window.innerWidth,
                height: window.innerHeight,
            })
        }

        window.addEventListener('resize', handleResize)
        handleResize()

        return () => window.removeEventListener('resize', handleResize)
    }, [])

    return windowSize
}

/**
 * Hook to track scroll position
 */
export function useScrollPosition() {
    const [scrollPos, setScrollPos] = useState(0)

    useEffect(() => {
        const handleScroll = () => setScrollPos(window.scrollY)
        window.addEventListener('scroll', handleScroll)
        return () => window.removeEventListener('scroll', handleScroll)
    }, [])

    return scrollPos
}
