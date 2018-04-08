var app=angular.module("testModule",[]);

app.controller("firstController",test);

function test($scope)
{
	$scope.testClick = function()
	{
	  alert("hello");
	}
}