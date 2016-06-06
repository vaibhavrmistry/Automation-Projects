//
//  Tester_TesterUITests.swift
//  Tester TesterUITests
//
//  Created by Brenton Durkee on 12/18/15.
//  Copyright © 2015 Test. All rights reserved.
//

import XCTest

extension XCUIElement {
    
    func scrollToElement(element: XCUIElement) {
        while !element.visible() {
            swipeUp()
        }
    }
    
    func visible() -> Bool {
        guard self.exists && !CGRectIsEmpty(self.frame) else { return false }
        return CGRectContainsRect(XCUIApplication().windows.elementBoundByIndex(0).frame, self.frame)
    }
    
}

class Tester_TesterUITests: XCTestCase {
    
    override func setUp() {
        super.setUp()
        continueAfterFailure = false;
        XCUIApplication().launch();
        // Put setup code here. This method is called before the invocation of each test method in the class.
        
        // In UI tests it is usually best to stop immediately when a failure occurs.
        continueAfterFailure = false
        // UI tests must launch the application that they test. Doing this in setup will make sure it happens for each test method.
        XCUIApplication().launch()

        // In UI tests it’s important to set the initial state - such as interface orientation - required for your tests before they run. The setUp method is a good place to do this.
    }
    
    override func tearDown() {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
        super.tearDown()
    }
    
   
    
    func testExample() {
        // Use recording to get started writing UI tests.
        // Use XCTAssert and related functions to verify your tests produce the correct results.
        let app = XCUIApplication()
        let table = app.tables.elementBoundByIndex(0)
        //refer to 5th cell and scroll to it
        let fifthCell = table.cells.elementBoundByIndex(4)
        table.scrollToElement(fifthCell)
        fifthCell.tap()
        //refer to the comment field and wait till it exists
        let commentField = app.textFields.elementBoundByIndex(0)
        let exists = NSPredicate(format: "exists == 1")
        expectationForPredicate(exists, evaluatedWithObject: commentField, handler: nil)
        waitForExpectationsWithTimeout(5, handler: nil)
        commentField.tap()
        //add a comment. You can change the comment text here
        let commentText = "Comment"
        commentField.typeText(commentText)
        app.buttons["Add Comment"].tap()
        let commentsView = app.textViews.elementBoundByIndex(0)
        //as in the code, /n is added as prefix while adding a comment, we add the /n check
        XCTAssertEqual(commentsView.value as? String, "\n"+commentText)
        
        
        
    }
    
}
