import {Component, OnInit} from '@angular/core';
import {CommonModule} from '@angular/common';
import {GatheringDto, GatheringService} from "../generated";
import {MatTableDataSource, MatTableModule} from "@angular/material/table";

@Component({
  selector: 'app-gathering-list',
  standalone: true,
  imports: [CommonModule, MatTableModule],
  templateUrl: './gathering-list.component.html',
  styleUrl: './gathering-list.component.scss'
})
export class GatheringListComponent implements OnInit {
  gatherings!: MatTableDataSource<GatheringDto>;
  displayedColumns: string[] = ['id', 'ownerId', 'description']

  constructor(public gatheringService: GatheringService) {
  }

  ngOnInit(): void {
    this.getAllGatherings();
  }

  getAllGatherings(): void {
    this.gatheringService.getGatherings().subscribe(
      (gatheringList: GatheringDto[]) => {
        this.gatherings = new MatTableDataSource(gatheringList);
      }
    );
  }

}
