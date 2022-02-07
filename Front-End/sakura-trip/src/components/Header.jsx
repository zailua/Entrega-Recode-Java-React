import React from 'react'
import Contato from '../Pages/Contato'
import Destino from '../Pages/Destino'
import Promo from '../Pages/Promo'
import Home from '../Pages/Home'
import {
	BrowserRouter as Router,
	Route,
	Routes,
	Link,
	NavLink
} from 'react-router-dom'
import './Header.css'

function Header() {
	return (
		<Router>
			<header>
				<nav>
					<label className="logo">
						<img src="./src/assets/sakura.png" alt="logo.png" />
					</label>
					<input type="checkbox" id="check" />
					<label for="check" className="button">
						<span></span>
						<span></span>
						<span></span>
					</label>
					<ul class="menu">
						<li>
							<NavLink activeClassName="active" to="/">
								Home
							</NavLink>
						</li>
						<li>
							<NavLink activeClassName="active" to="/destiny">
								Destinos
							</NavLink>
						</li>
						<li>
							<NavLink activeClassName="active" to="/promos">
								Promoções
							</NavLink>
						</li>
						<li>
							<NavLink activeClassName="active" to="/contact">
								Contato
							</NavLink>
						</li>
					</ul>
				</nav>
			</header>

			<Routes>
				<Route path="/" element={<Home />} />
				<Route path="/destiny" element={<Destino />} />
				<Route path="/promos" element={<Promo />} />
				<Route path="/contact" element={<Contato />} />
			</Routes>
		</Router>
	)
}
export default Header
