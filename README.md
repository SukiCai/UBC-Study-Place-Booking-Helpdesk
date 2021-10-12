# UBC Study Place Booking Helpdesk

## Suki's Term Project

The purpose of the project
- Give UBC students in resident to **discover a study place inside the UBC** according to their preference
- Help the student to **book a place** for the chosen library

The aiming user:

- UBC students in resident

The reason why this project of interest to me:
When I am new to UBC, I do not familiar with the whole environment, so I spend a lot of time to find out a suitable
place to study, ever after a year many of my friends still not sure about all the study room that UBC provided for 
students. Therefore, I want to build up a helpdesk for students to discover the most suitable place.


##User Stories

- As a user, I want to choose to find a study place or directly book a study place.
- As a user, I want to select a choice between "closest" "The highest rate" "The largest amount of books" to 
  gain a rank of satisfied study place.
- As a user, I want to give the location to find out the closest study place I want to go.
- As a user, I want to choose one from given study place and book a place in my chosen library.
- As a user, I want to view a list of available time to book in my chosen study place.
- As a user, I want to add my student number to the booking status and delete my chosen time from the 
  time available list.
- As a user, I want to view my booked time and personal information of my booking.
- As a user, I want to quit any time if I want.
- As a user, I want to be able to save my booked list to file
- As a user, I want to be able to load my booked list from file 

##Phase 4: Task 2
- Chosen: Make appropriate use of the Map interface somewhere in your code
- Implement: Class: InformationManager
- Implement: Methods: makeANameAndTimeMap(), makeANameMap(),handleUserInputStudyOrBook(String typedString)
  ,parseInputBook(String typedString),parseInputTimeSlot(String str, String libraryName),
  madeALibraryMapWithScore(),madeALibraryMapWithBooks()

##Phase 4: Task 3
- Possible refactoring1: refactoring the instruction print methods in informationManager class to reduce the duplicate
- Possible refactoring2: refactoring the informationManager into two class: one is for manageInput and anther class
  for printing the instructions.


