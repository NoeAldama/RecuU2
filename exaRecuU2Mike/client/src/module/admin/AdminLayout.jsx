
import React from 'react'; import {
  Avatar, Button, Timeline,
  Dropdown, Card ,
  DropdownDivider,
  DropdownHeader,
  DropdownItem,
  Navbar,
  Badge,
  NavbarBrand,
  NavbarCollapse,
  NavbarLink,
  NavbarToggle,
  Sidebar,
} from 'flowbite-react';
import AuthContext from '../../config/context/auth-context';
import { HiArrowSmRight, HiChartPie, HiInbox, HiShoppingBag, HiTable, HiUser, HiViewBoards, HiArrowNarrowRight, HiCalendar, } from 'react-icons/hi';
import { Outlet, Link } from 'react-router-dom';


const AdminLayout = () => {
  //Diseñar el layout para admin
  return (
      <>
          <header>
              <Navbar fluid rounded>
                  <Navbar.Brand href="https://flowbite-react.com" >
                      <img src="https://images.pexels.com/photos/5506894/pexels-photo-5506894.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"className="mr-3 h-6 sm:h-9" alt="" width={75} />
                      <span className="self-center whitespace-nowrap text-xl font-semibold dark:text-white">Admin</span>
                  </Navbar.Brand>
                  <div className="flex md:order-2">
                      <Dropdown
                          arrowIcon={false}
                          inline
                          label={
                              <Avatar alt="User settings" img="https://images.pexels.com/photos/771742/pexels-photo-771742.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500" rounded />
                          }
                      >
                          <DropdownHeader>
                              <span className="block text-sm">Noe</span>
                              <span className="block truncate text-sm font-medium">name@flowbite.com</span>
                          </DropdownHeader>
                          <DropdownItem>Dashboard</DropdownItem>
                          <DropdownItem>Settings</DropdownItem>
                          <DropdownItem>Earnings</DropdownItem>
                          <DropdownDivider />
                          <DropdownItem>Sign out</DropdownItem>
                      </Dropdown>
                      <NavbarToggle />
                  </div>
                  <NavbarCollapse>
                      <NavbarLink href="#" active>
                          Home
                      </NavbarLink>
                      <NavbarLink href="#">About</NavbarLink>
                      <NavbarLink href="#">Services</NavbarLink>
                      <NavbarLink href="#">Pricing</NavbarLink>
                      <NavbarLink href="#">Contact</NavbarLink>
                  </NavbarCollapse>
              </Navbar>

          </header>

          <div className='flex' >
              <aside>
                  <Sidebar aria-label="Sidebar with call to action button example">
                      <Sidebar.Items>
                          <Sidebar.ItemGroup>
                              <Sidebar.Item href="#" icon={HiChartPie}>
                                  Dashboard
                              </Sidebar.Item>
                              <Sidebar.Item href="#" icon={HiViewBoards}>
                                  Kanban
                              </Sidebar.Item>
                              <Sidebar.Item href="#" icon={HiInbox}>
                                  Inbox
                              </Sidebar.Item>
                              <Sidebar.Item href="#" icon={HiUser}>
                                  Users
                              </Sidebar.Item>
                              <Sidebar.Item href="#" icon={HiShoppingBag}>
                                  Products
                              </Sidebar.Item>
                              <Sidebar.Item href="#" icon={HiArrowSmRight}>
                                  Sign In
                              </Sidebar.Item>
                              <Sidebar.Item href="#" icon={HiTable}>
                                  Sign Up
                              </Sidebar.Item>
                          </Sidebar.ItemGroup>
                      </Sidebar.Items>
                      <Sidebar.CTA>
                          <div className="mb-3 flex items-center">
                              <Badge color="warning">Beta</Badge>
                              <button
                                  aria-label="Close"
                                  className="-m-1.5 ml-auto inline-flex h-6 w-6 rounded-lg bg-gray-100 p-1 text-cyan-900 hover:bg-gray-200 focus:ring-2 focus:ring-gray-400 dark:bg-gray-700 dark:text-gray-400 dark:hover:bg-gray-600"
                                  type="button"
                              >
                                  <svg
                                      aria-hidden
                                      className="h-4 w-4"
                                      fill="currentColor"
                                      viewBox="0 0 20 20"
                                      xmlns="http://www.w3.org/2000/svg"
                                  >
                                      <path
                                          fillRule="evenodd"
                                          d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z"
                                          clipRule="evenodd"
                                      />
                                  </svg>
                              </button>
                          </div>
                          <div className="mb-3 text-sm text-cyan-900 dark:text-gray-400">
                              Preview the new Flowbite dashboard navigation! You can turn the new navigation off for a limited time in your
                              profile.
                          </div>
                          <a
                              className="text-sm text-cyan-900 underline hover:text-cyan-800 dark:text-gray-400 dark:hover:text-gray-300"
                              href="#"
                          >
                              Turn new navigation off
                          </a>
                      </Sidebar.CTA>
                  </Sidebar>

              </aside >
              <main className='w-full'>
                  <section className='px-4 pt-2 pb-6'>
                      <Outlet />
                  </section>
              </main>
          </div>
      </>
  )
}

export default AdminLayout