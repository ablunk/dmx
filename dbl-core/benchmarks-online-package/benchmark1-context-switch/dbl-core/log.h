/*
 * DBL Core
 * Copyright (C) 2013 Andreas Blunk
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

#ifndef __LOG_H
#define __LOG_H

#include <iostream>
#include <stdlib.h>

#ifdef PRINT_LOG
    #define log(MSG) std::cout << "(pid-" << cx->pid << ") " << MSG << std::endl;
    #define log2(MSG) std::cout << MSG << std::endl;
#else
    #define log(MSG) 
    #define log2(MSG) 
#endif

#define print(MSG) std::cout << MSG << std::endl;
#define pprint(MSG) std::cout << "pid-" << cx->pid << ": " << MSG << std::endl;

#endif
