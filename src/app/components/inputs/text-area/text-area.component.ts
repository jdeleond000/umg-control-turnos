import { Component, Input, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-text-area',
  templateUrl: './text-area.component.html',
  styleUrls: ['./text-area.component.css'],
})
export class TextAreaComponent implements OnInit {
  @Input() name: string = '';
  @Input() group!: FormGroup;
  @Input() maxLength: number = 0;
  @Input() minLength: number = 0;
  @Input() rangeLines: number[] = [1, 5];
  @Input() disable: boolean = false;
  @Input() value: string = '';
  constructor() {}
  // Text area
  ngOnInit(): void {}
}
