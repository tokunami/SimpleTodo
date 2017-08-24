# Pre-work - SimpleToDo

SimpleToDo is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: Nami Tokunaga

Time spent: 15 hours spent in total

## User Stories

The following **required** functionality is completed:

* [x] User can **successfully add and remove items** from the todo list
* [x] User can **tap a todo item in the list and bring up an edit screen for the todo item** and then have any changes to the text reflected in the todo list.
* [x] User can **persist todo items** and retrieve them properly on app restart

The following **optional** features are implemented:

* [ ] Persist the todo items [into SQLite](http://guides.codepath.com/android/Persisting-Data-to-the-Device#sqlite) instead of a text file
* [x] Improve style of the todo items in the list [using a custom adapter](http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView)
* [ ] Add support for completion due dates for todo items (and display within listview item)
* [ ] Use a [DialogFragment](http://guides.codepath.com/android/Using-DialogFragment) instead of new Activity for editing items
* [ ] Add support for selecting the priority of each todo item (and display in listview item)
* [ ] Tweak the style improving the UI / UX, play with colors, images or backgrounds

The following **additional** features are implemented:

* [x] Prevent user from adding empty item titles when clicking on add/save in the AddItemActivity/EditItemActivity
* [x] Add behaviours that are alert and return without saving when clicking on the default back bottun in the EditItemActivity


## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='http://imgur.com/a5sO6fz.gif' title='Video Walkthrough' width='300' alt='Video Walkthrough' />

## Project Analysis

As part of your pre-work submission, please reflect on the app and answer the following questions below:

**Question 1:** "What are your reactions to the Android app development platform so far? Compare and contrast Android's approach to layouts and user interfaces in past platforms you've used."

**Answer:** There are many characteristic points to build Android apps easily. Particularly I felt so about following 3 things. 1) 1 Activity == 1 UI Screen, 2) the GUI for screen design, and 3)`intent` and `context`. The former 2 things are easy to use intuitively, the latter one is not so intuitive but helpful to design screen transitions. In comparison to React which is function-oriented(I feel) JavaScript based platform, it's easier to understand and better for small apps. However, it might be demerit with insufficient understanding. 1 would be too many similar activities, 2 would be unintended, unnecessary code injection in XML. About 3, it's still confusing to use its functions fully(i.e. no guideline for `request code` in `startActivityForResult`). Also, AndroidStudio is the most helpful SDK for me so far. Overall, I feel it's easy to understand, good to know its basic approach. I want to develop Android apps more deeply.

**Question 2:** "Take a moment to reflect on the `ArrayAdapter` used in your pre-work. How would you describe an adapter in this context and what is its function in Android? Why do you think the adapter is important? Explain the purpose of the `convertView` in the `getView` method of the `ArrayAdapter`."

**Answer:** Adapter serves to bridge data between Activity and View. Also, adapter has many roles in Android, for example, to generate contents of View, to adjust and reuse View, and so on. I think adapter is important from the viewpoint of functional programming because small and clear functional class is easy to extend and override. In `ArrayAdapter`, `convertView` is used for judgment of reuse contents, which means that as `convertView` has contents which disappeared on a display, it's reused when it isn't null without making other new instance. It's good for memory saving and speed. On the other hand, we may need to weigh carefully it was used before or not.
## Notes



## License

    Copyright 2017 Nami Tokunaga

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

